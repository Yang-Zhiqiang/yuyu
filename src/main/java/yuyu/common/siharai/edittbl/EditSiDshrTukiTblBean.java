package yuyu.common.siharai.edittbl;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * 保険金給付金Ｄ支払統計TBL編集Bean
 */
public class EditSiDshrTukiTblBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private JT_SiKykKihon siKykKihon;

    private JT_SiKykSyouhn siKykSyouhn;

    private EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean;

    private String skno;

    private Integer seikyuurirekino;

    private BizDate syoriYmd;

    private BizDate denymd;

    private BizCurrency siharaid;

    private String gyoumuKousinsyaId;

    private String gyoumuKousinKinou;

    public JT_SiKykKihon getSiKykKihon() {
        return siKykKihon;
    }

    public void setSiKykKihon(JT_SiKykKihon siKykKihon) {
        this.siKykKihon = siKykKihon;
    }

    public JT_SiKykSyouhn getSiKykSyouhn() {
        return siKykSyouhn;
    }

    public void setSiKykSyouhn(JT_SiKykSyouhn siKykSyouhn) {
        this.siKykSyouhn = siKykSyouhn;
    }

    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {
        return editDshrTukiDKoumokuBean;
    }

    public void setEditDshrTukiDKoumokuBean(EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean) {
        this.editDshrTukiDKoumokuBean = editDshrTukiDKoumokuBean;
    }

    public String getSkno() {
        return skno;
    }

    public void setSkno(String skno) {
        this.skno = skno;
    }

    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer seikyuurirekino) {
        this.seikyuurirekino = seikyuurirekino;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate syoriYmd) {
        this.syoriYmd = syoriYmd;
    }

    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate denymd) {
        this.denymd = denymd;
    }

    public BizCurrency getSiharaid() {
        return siharaid;
    }

    public void setSiharaid(BizCurrency siharaid) {
        this.siharaid = siharaid;
    }

    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String gyoumuKousinsyaId) {
        this.gyoumuKousinsyaId = gyoumuKousinsyaId;
    }

    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String gyoumuKousinKinou) {
        this.gyoumuKousinKinou = gyoumuKousinKinou;
    }
}
