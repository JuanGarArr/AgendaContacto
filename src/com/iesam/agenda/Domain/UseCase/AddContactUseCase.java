package com.iesam.agenda.Domain.UseCase;

import com.iesam.agenda.Domain.ContactRepository;
import com.iesam.agenda.Domain.Models.Contacto;

public class AddContactUseCase {

    private ContactRepository contactRepository;

    public AddContactUseCase (ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    public void execute (Contacto contacto){


    }
}
