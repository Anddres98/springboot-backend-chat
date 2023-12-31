package com.andres.springboot.backend.chat.controllers;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.andres.springboot.backend.chat.models.documents.Mensaje;

@Controller
public class ChatController {
	
	//Va recibir el mensaje del cliente
	@MessageMapping("/mensaje")
	@SendTo("/chat/mensaje")//nombre del evento adonde vamos enviar el mensaje corresponde al configadurado en el config
	public Mensaje recibeMensaje(Mensaje mensaje) {
		mensaje.setFecha(new Date().getTime());
		
		if(mensaje.getTipo().equals("NUEVO_USUARIO")){
			mensaje.setTexto("nuevo usuario");
		}
		return mensaje;
	}

}
