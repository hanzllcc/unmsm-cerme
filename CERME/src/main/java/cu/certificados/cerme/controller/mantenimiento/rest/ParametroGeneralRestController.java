package cu.certificados.cerme.controller.mantenimiento.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.certificados.cerme.model.mantenimiento.ParametroGeneral;
import cu.certificados.cerme.service.IParametroGeneralService;
import cu.certificados.cerme.utilitario.ConstantesGenerales;

@RequestMapping("/mantenimiento/parametroGeneral")
public @RestController class ParametroGeneralRestController {
	private @Autowired IParametroGeneralService parametroGeneralService;

	@GetMapping(params = "accion=buscarTodos")
	public List<ParametroGeneral> buscarTodos() {
		System.out.println(parametroGeneralService.buscarTodos());
		return parametroGeneralService.buscarTodos();
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarFacultad(@RequestBody ParametroGeneral parametroGeneral)
    {
		parametroGeneralService.actualizarParametroGeneral(parametroGeneral);
        return ResponseEntity.ok(ConstantesGenerales.ACTUALIZACION_EXITOSA);
    }

}
