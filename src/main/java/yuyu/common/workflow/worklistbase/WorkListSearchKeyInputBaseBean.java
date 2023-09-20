package yuyu.common.workflow.worklistbase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;

/**
 * 工程ワークリスト : 検索条件保持用Beanの親クラスです。<br />
 */
public class WorkListSearchKeyInputBaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jimuyoucd;

    public String getJimuyoucd() {
        return jimuyoucd;
    }

    public void setJimuyoucd(String pJimuyoucd) {
        jimuyoucd = pJimuyoucd;
    }

    private Boolean jmycdMisetteiKbn;

    public Boolean getJmycdMisetteiKbn() {
        return (jmycdMisetteiKbn == null) ? Boolean.FALSE : jmycdMisetteiKbn;
    }

    public void setJmycdMisetteiKbn(Boolean pJmycdMisetteiKbn) {
        jmycdMisetteiKbn = (pJmycdMisetteiKbn == null) ? Boolean.FALSE : pJmycdMisetteiKbn;
    }

    private BizDate jimustartYmdFrom;

    public BizDate getJimustartYmdFrom() {
        return jimustartYmdFrom;
    }

    public void setJimustartYmdFrom(BizDate pJimustartYmdFrom) {
        jimustartYmdFrom = pJimustartYmdFrom;
    }

    private BizDate jimustartYmdTo;

    public BizDate getJimustartYmdTo() {
        return jimustartYmdTo;
    }

    public void setJimustartYmdTo(BizDate pJimustartYmdTo) {
        jimustartYmdTo = pJimustartYmdTo;
    }

    public static class LoopChain<E> implements Serializable {

        private static final long serialVersionUID = 8951175050558419495L;

        private List<E> contents = new ArrayList<E>();
        private int index = -1;

        public LoopChain() {
        }

        public void add(E e) {
            contents.add(e);
        }

        public E get() {
            if (contents.isEmpty()) {
                return null;
            }

            index++;
            index = index % contents.size();
            return contents.get(index);
        }

        public void clear() {
            contents.clear();
            index = -1;
        }
    }
}
