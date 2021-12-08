package py.com.jbx.solo.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import py.com.jbx.solo.model.entity.Empleado;
import py.com.jbx.solo.model.service.IEmpleadoService;

@Controller
@SessionAttributes("empleado")
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@InitBinder
	public void initbinder(WebDataBinder binder) {
		StringTrimmerEditor recortaString= new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, recortaString);
	}
	
	@GetMapping("/")
	public String inicio() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String home() {
		return "index";
	}
	
	@GetMapping("/lista")
	public String listaEmpleados(Model model) {
		model.addAttribute("titulo","Lista de Empleados");
		model.addAttribute("empleados", empleadoService.listar());
		return "lista";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Empleado empleado= new Empleado();
		model.addAttribute("empleado", empleado);
		model.addAttribute("titulo","Registo Empleado");
		return "form";
	}
	@GetMapping("/form/{id}")
	public String formEditar(@PathVariable Long id, Model model) {
		Empleado empleado= empleadoService.buscar(id);
		model.addAttribute("empleado", empleado);
		model.addAttribute("titulo","Actualizar Empleado");
		return "form";
	}
	
	@PostMapping("/form")
	public String formGuardar(@Valid Empleado empleado, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Registro Empleado");
			return "form";
		}
		String mensaje= empleado.getId() == null? "Agregado con éxito!": "Actualizado con éxito!";
		empleadoService.guardar(empleado);
		status.setComplete();
		flash.addFlashAttribute("success",mensaje);
		return "redirect:/lista";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, Model model, RedirectAttributes flash) {
			flash.addFlashAttribute("success", "Eliminado con éxito!");
			empleadoService.eliminar(id);
			return "redirect:/lista";
		
	}
	
	@ModelAttribute("salarioTotal")
	public Long sumaSalario(Model model) {
		List<Empleado> empleado= empleadoService.listar();
		model.addAttribute("suma",empleado.size());
		Long salarioTotal=0L;
		for(Empleado t: empleado) {
			salarioTotal+=t.getSalario();
		}
		return salarioTotal;
	}
	
	
	@PostMapping("/listarpornombre")
	public String listaPorNombreEmpleado(@RequestParam String nombreBuscar, Model model) {
		model.addAttribute("titulo","Lista de Empleados");
		model.addAttribute("empleados", empleadoService.BuscarEmpleadoByNombre(nombreBuscar));
		return "lista";
	}
}
