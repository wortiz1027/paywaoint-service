package co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.endpoint;

import co.edu.javeriana.external.service.paywaoint.application.CreditServices;
import co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model.ChargeCreditCardElement;
import co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model.ChargeCreditCardResponseElement;
import co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model.VerifyCreditCardElement;
import co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model.VerifyCreditCardResponseElement;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class CreditEndPoint {

    private final CreditServices services;

    @PayloadRoot(namespace = "http://services.creditverifier.com/", localPart = "VerifyCreditCard")
    @ResponsePayload
    public VerifyCreditCardResponseElement getFlights(@RequestPayload VerifyCreditCardElement request) {
        return services.validateCreditCard(request);
    }

    @PayloadRoot(namespace = "http://services.creditverifier.com/", localPart = "ChargeCreditCard")
    @ResponsePayload
    public ChargeCreditCardResponseElement getAllFlights(@RequestPayload ChargeCreditCardElement request) {
        return services.paymentCreditCard(request);
    }


}
