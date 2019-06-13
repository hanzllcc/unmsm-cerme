package cu.certificados.cerme.controller.mantenimiento.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.certificados.cerme.aspecto.anotacion.Audit;
import cu.certificados.cerme.aspecto.enumeracion.Accion;
import cu.certificados.cerme.aspecto.enumeracion.Comentario;
import cu.certificados.cerme.aspecto.enumeracion.Dato;
import cu.certificados.cerme.aspecto.enumeracion.Tipo;
import cu.certificados.cerme.model.mantenimiento.Medico;
import cu.certificados.cerme.service.IMedicoService;
import cu.certificados.cerme.utilitario.ConstantesGenerales;

@Audit(tipo = Tipo.Medico, datos = Dato.Medico)
@RequestMapping("/mantenimiento/medico")
public @RestController class MedicoRestController
{
    private @Autowired IMedicoService medicoService;

    @Audit(accion = Accion.Consulta, comentario = Comentario.ConsultaTodos)
    @GetMapping(params = "accion=buscarTodos")
    public List<Medico> buscarTodos()
    {
        return medicoService.buscarTodos();
    }

    @Audit(accion = Accion.Registro, comentario = Comentario.Registro)
    @PostMapping
    public ResponseEntity<?> registrarMedico(@RequestBody Medico medico)
    {
        medicoService.registrarMedico(medico);
        return ResponseEntity.ok(medicoService.buscarPorTipoDocumentoNumeroDocumento(
                medico.getIdTipoDocumento(), medico.getNumeroDocumento()));
    }

    @Audit(accion = Accion.Actualizacion, comentario = Comentario.Actualizacion)
    @PutMapping
    public ResponseEntity<?> actualizarMedico(@RequestBody Medico medico)
    {
        medicoService.actualizarMedico(medico);
        return ResponseEntity.ok(medicoService.buscarPorTipoDocumentoNumeroDocumento(
                medico.getIdTipoDocumento(), medico.getNumeroDocumento()));
    }

    @Audit(accion = Accion.Eliminacion, comentario = Comentario.Eliminacion)
    @DeleteMapping
    public ResponseEntity<?> eliminarMedico(@RequestBody Medico medico)
    {
        medicoService.eliminarMedico(medico);
        return ResponseEntity.ok(ConstantesGenerales.ELIMINACION_EXITOSA);
    }
}