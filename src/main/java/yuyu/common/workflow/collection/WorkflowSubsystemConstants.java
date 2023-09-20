package yuyu.common.workflow.collection;

/**
 * WorkflowSubsystemのコレクション操作に使用する定数クラスです。<br/>
 */
public class WorkflowSubsystemConstants {

    public enum E_SubSystem {

        SINKEIYAKU ("sinkeiyaku",1),
        KEIYAKUHOZEN("hozen",2),
        HOKENKYUHUSIHARAI("siharai",3),
        NENKINSIHARAI("nenkin",4);

        private String subSystemId;

        private int sortId;

        E_SubSystem(String subSystemId,int sortId) {
            this.subSystemId = subSystemId;
            this.sortId = sortId;
        }

        public String getSubSystemId() {
            return subSystemId;
        }

        public int getSortId() {
            return sortId;
        }

    }

}
