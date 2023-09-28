package yuyu.common.biz.renkei;

import java.util.List;

public abstract class WorklistViewValuesCreator {

    public static List<WorklistViewValuesBean> createValues(String pSubsystemid, List<WorklistViewValuesBean> list) {

        List<WorklistViewValuesBean> retList = null;
        try {
            retList = WorklistViewValuesCreatorFactory.getCreator(pSubsystemid).create(list);
        } catch (ClassNotFoundException e) {
            retList = list;
        }

        return retList;
    }

    public abstract List<WorklistViewValuesBean> create(List<WorklistViewValuesBean> list);
}
