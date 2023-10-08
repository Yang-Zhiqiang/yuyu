package yuyu.batch.biz.bzinterf.bzlinckyknaiyousks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;

/**
 * 業務共通 インターフェース 契約保全ＬＩＮＣ送信データBeanクラスです。<br />
 */
@AllArgsConstructor
public class KhLincSousinDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syono;

    private BizDate syoriYmd;

    private Integer renno;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
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
