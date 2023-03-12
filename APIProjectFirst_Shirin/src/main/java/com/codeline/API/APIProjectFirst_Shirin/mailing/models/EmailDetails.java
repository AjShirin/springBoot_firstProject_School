package com.codeline.API.APIProjectFirst_Shirin.mailing.models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor // comes as parameter in the constructor
@NoArgsConstructor // comes without parameter in the constructor
@Getter // generates getter
@Setter // generates setter
public class EmailDetails {

        private List<String> recipient; // the person who will get the msg
        private String msgBody;
        private String subject;
        private String attachment; // it is sting because we need to copy the path of the attachment
    }
