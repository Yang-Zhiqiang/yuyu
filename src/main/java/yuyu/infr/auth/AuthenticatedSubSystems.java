package yuyu.infr.auth;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.servlet.SessionScoped;

/**
 * サブシステムの情報を受け渡しするためのクラスです。
 */
@SessionScoped
public class AuthenticatedSubSystems implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<SubSystem> subSystems = Lists.newArrayList();


    public void addSubSystem(SubSystem pSubSytem){
        if(pSubSytem != null){
            subSystems.add(pSubSytem);
        }
    }

    public List<SubSystem> getSubSystems(){

        Collections.sort(subSystems,
            new Comparator<SubSystem>() {
            @Override
            public int compare(SubSystem pSubSystem1,SubSystem pSubSystem2) {
                return pSubSystem1.getSortNo().compareTo(
                    pSubSystem2.getSortNo());
            }
        });

        return subSystems;

    }

}
