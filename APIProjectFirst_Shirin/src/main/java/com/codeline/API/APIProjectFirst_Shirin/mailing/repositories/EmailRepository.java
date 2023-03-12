package com.codeline.API.APIProjectFirst_Shirin.mailing.repositories;

import com.codeline.API.APIProjectFirst_Shirin.mailing.models.EmailDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository {
    String sendSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);
}
