package yuyu.infrext.mq;

import jp.co.slcs.acs.mqi.api.ACSMqAPI;


public class MqApiFactoryImpl {

    MqApiFactoryImpl(){
    }

    public ACSMqAPI create(){

        ACSMqAPI acsMqApi = ACSMqAPI.getInstance();

        return acsMqApi;

    }

}

