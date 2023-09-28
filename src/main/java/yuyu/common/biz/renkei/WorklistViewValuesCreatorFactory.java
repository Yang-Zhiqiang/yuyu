package yuyu.common.biz.renkei;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.workflow.manager.WorkflowDomManager;


public class WorklistViewValuesCreatorFactory {

    @Inject
    WorkflowDomManager workflowDomManager;

    public static WorklistViewValuesCreator getCreator(String pSubsystemid) throws ClassNotFoundException{

        switch(pSubsystemid){
            case "sinkeiyaku":
                return (WorklistViewValuesCreator)SWAKInjector.getInstance(Class.forName("yuyu.common.sinkeiyaku.renkei.SinkeiyakuWorklistViewValuesCreator"));
            case "hozen":
                return (WorklistViewValuesCreator)SWAKInjector.getInstance(Class.forName("yuyu.common.hozen.renkei.HozenWorklistViewValuesCreator"));
            case "siharai":
                return (WorklistViewValuesCreator)SWAKInjector.getInstance(Class.forName("yuyu.common.siharai.renkei.SiharaiWorklistViewValuesCreator"));
            case "nenkin":
                return (WorklistViewValuesCreator)SWAKInjector.getInstance(Class.forName("yuyu.common.nenkin.renkei.NenkinWorklistViewValuesCreator"));
            default:
                return (WorklistViewValuesCreator)SWAKInjector.getInstance(Class.forName("yuyu.common.sinkeiyaku.renkei.SinkeiyakuWorklistViewValuesCreator"));
        }
    }
}
