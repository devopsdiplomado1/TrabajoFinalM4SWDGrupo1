package com.devops.dxc.devops.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Util {

    /**
     * Método para cacular el 10% del ahorro en la AFP.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     * 
     * @param ahorro
     * @return int
     */
    public static int getDxc(int ahorro){
        int valorUf = getUf();
        if(((ahorro*0.1)/valorUf) > 150 ){
            return (int) (150*valorUf) ;
        } else if(ahorro > (35 * valorUf) && ahorro <= (35 * valorUf * 10)){
            return (int) (35 * valorUf);
        } else if( ahorro <= (35 * valorUf)){
            return (int) ahorro;
        } else {
            return (int) (ahorro*0.1);
        }
    }

    /**
     * Método que retorna el valor de la UF.
     * @return int
     */
    public static int getUf() {

        RestTemplate restTemplate = new RestTemplate();
        String mindicadorEndpoint = "https://mindicador.cl/api";
        System.out.println("invocando ruta mindicador: " + mindicadorEndpoint);

        ResponseEntity<String> response = restTemplate.getForEntity(mindicadorEndpoint, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        JsonNode ufObject = root.path("uf");
        System.out.println("obteniendo valor UF: " + ufObject.path("valor").asInt());

        return ufObject.path("valor").asInt();
    }

    /**
     * Método que retorna el saldo de Ahorro - retiro 10%.
     * @param ahorro
     * @return int
     */
    public static int getSaldo(int ahorro, int dxc){
        return ahorro - dxc;
    }

    /**
     * Método que retorna el valor del impuesto según el sueldo ingresado.
     *      * Tramo de remuneración:
     *      * TR: $0 - $500.000 | Impuesto a cancelar: $0
     *      * TR: $500.000 - $1.000.000 | IMP. $0
     *      * TR: $1.000.000 - $1.500.000 | IMP: $0
     *      * TR: $1.500.000 - $2.500.000 | IMP: $174.531
     *      * TR: $2.500.000 - 3.000.000 | IMP: $364.086
     *      * TR: $3.000.000 - $4.000.000 | IMP: $612.396
     *      * TR: $4.000.000 - $5.000.000 | IMP: 980.357
     *      * TR: $5.000.000 - $6.000.000 | IMP: 1.294.052
     *      * TR: $6.000.000 y más | IMP: $1.491.042
     * @param sueldo
     * @return int
     */
    public static int getImpuesto(int sueldo){
        int impuesto = 0;

        if ( sueldo >= 0 && sueldo < 1500000)
            impuesto = 0;
        else if ( sueldo >= 1500000  && sueldo < 2500000)
            impuesto = 	174531;
        else if ( sueldo >= 2500000  && sueldo < 3000000)
            impuesto = 	364086;
        else if ( sueldo >= 3000000  && sueldo < 4000000)
            impuesto = 	612396;
        else if ( sueldo >= 4000000  && sueldo < 5000000)
            impuesto = 	980357;
        else if ( sueldo >= 5000000  && sueldo < 6000000)
            impuesto = 	1294052;
        else if ( sueldo >= 6000000)
            impuesto = 	1491042;

        return (int) impuesto;
    }
    
}
