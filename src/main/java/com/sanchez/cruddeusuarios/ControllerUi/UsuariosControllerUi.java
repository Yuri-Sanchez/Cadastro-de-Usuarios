package com.sanchez.cruddeusuarios.ControllerUi;

import com.sanchez.cruddeusuarios.DTO.UsuariosDTO;
import com.sanchez.cruddeusuarios.Service.UsuariosService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/usuarios/ui")
public class UsuariosControllerUi {

    private final UsuariosService usuariosService;

    public UsuariosControllerUi(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping("/adicionar")
    public String formularioAdicionarUsuario(Model model){
        model.addAttribute("usuario", new UsuariosDTO());
        return "cadastrarUsuario";
    }

    @GetMapping("/listar")
    public String listarUsuarios(Model model){
        List<UsuariosDTO> usuarios = usuariosService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "listarTodos";
    }

    @GetMapping("/listar/{id}")
    public String listarPorId(@PathVariable Long id, Model model){
        UsuariosDTO usuario = usuariosService.listarUsuarioPorId(id);
        if(usuario != null){
            model.addAttribute("usuario", usuario);
            return "detalhesUsuarios";
        }else{
            model.addAttribute("mensagem", "Usuário não encontrado");
            return "listarTodos";
        }
    }

    @GetMapping("/alterar")
    public String alterarUsuario(Model model){
        List<UsuariosDTO> usuarios = usuariosService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "alterarUsuario";
    }

    @GetMapping("/alterar/{id}")
    public String alterarUsuarioDireto(@PathVariable Long id, Model model){
        UsuariosDTO usuario = usuariosService.listarUsuarioPorId(id);

        if(usuario != null){
            model.addAttribute("usuario", usuario);
            return "formularioEditarUsuario";
        }else{
            return "redirect:/usuarios/ui/listar?erro=Usuario não encontrado";
        }
    }

    @PostMapping("/selecionar")
    public String selecionarUsuario(@RequestParam Long usuarioId){
        return "redirect:/usuarios/ui/editar/" + usuarioId;
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormulario(@PathVariable Long id, Model model){
        UsuariosDTO usuario = usuariosService.listarUsuarioPorId(id);

        if(usuario != null){
            model.addAttribute("usuario", usuario);
            return "formularioEditarUsuario";
        }else{
            return "redirect:/usuarios/ui/alterar?erro=Usuário não encontrado";
        }
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute UsuariosDTO usuarioAtualizado, RedirectAttributes redirectAttributes){
        usuariosService.atualizarUsuario(id, usuarioAtualizado);

        redirectAttributes.addFlashAttribute("mensagem", "Usuário alterado com sucesso!");

        return "redirect:/usuarios/ui/listar";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute UsuariosDTO usuario, RedirectAttributes redirectAttributes) {
        usuariosService.criarUsuario(usuario);
        redirectAttributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
        return "redirect:/usuarios/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarUsuarioPorId(@PathVariable Long id){
        usuariosService.deletar(id);
        return "redirect:/usuarios/ui/listar";
    }
}
