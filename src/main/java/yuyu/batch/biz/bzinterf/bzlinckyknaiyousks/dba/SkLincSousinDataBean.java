package yuyu.batch.biz.bzinterf.bzlinckyknaiyousks.dba;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * 業務共通 インターフェース 新契約ＬＩＮＣ送信データBeanクラスです。<br />
 */
@AllArgsConstructor
public class SkLincSousinDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mosno;

    private BizDate syoriYmd;

    private Integer renno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
