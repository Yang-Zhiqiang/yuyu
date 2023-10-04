package yuyu.batch.hozen.khinterf.khkzhurikaisiannaifsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 契約保全 インターフェイス 口座振替開始案内Ｆ作成Beanクラス<br />
 */
@AllArgsConstructor
public class KhKzhuriKaisiAnnaiFSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate tyouhyouymd;

    @Getter @Setter
    private C_SyoruiCdKbn syoruiCd;

    @Getter @Setter
    private C_HassouKbn hassoukbn;

    @Getter @Setter
    private String tsinyno;

    @Getter @Setter
    private String tsinadr1kj;

    @Getter @Setter
    private String tsinadr2kj;

    @Getter @Setter
    private String tsinadr3kj;

    @Getter @Setter
    private String kyknmkj;

    @Getter @Setter
    private String toiawasesosikinmkj;

    @Getter @Setter
    private String toiawaseyno;

    @Getter @Setter
    private String toiawaseadr1kj;

    @Getter @Setter
    private String toiawaseadr2kj;

    @Getter @Setter
    private String toiawaseadr3kj;

    @Getter @Setter
    private String toiawasetelno;

    @Getter @Setter
    private String toiawaseteluktkkanou1;

    @Getter @Setter
    private String toiawaseteluktkkanou2;

    @Getter @Setter
    private String toiawasesosikinmkj2;

    @Getter @Setter
    private String toiawasetelno2;

    @Getter @Setter
    private String tuutinm;

    @Getter @Setter
    private String aisatumongon1;

    @Getter @Setter
    private String aisatumongon2;

    @Getter @Setter
    private String aisatumongon3;

    @Getter @Setter
    private String aisatumongon4;

    @Getter @Setter
    private String aisatumongon5;

    @Getter @Setter
    private String kzhurikaeonegai1;

    @Getter @Setter
    private String kzhurikaeonegai2;

    @Getter @Setter
    private String kzhurikaeonegai3;

    @Getter @Setter
    private String kzhurikaeonegai4;

    @Getter @Setter
    private String kzhurikaeonegai5;

    @Getter @Setter
    private String kzhurikaeonegai6;

    @Getter @Setter
    private String kzhurikaeonegai7;

    @Getter @Setter
    private String kzhurikaeonegai8;

    @Getter @Setter
    private String kzhurikaeonegai9;

    @Getter @Setter
    private String kzhurikaeonegai10;

    @Getter @Setter
    private String kzhurikaeonegai11;

    @Getter @Setter
    private String kzhurikaeonegai12;

    @Getter @Setter
    private String kzhurikaeonegai13;

    @Getter @Setter
    private String kzhurikaeonegai14;

    @Getter @Setter
    private String kzhurikaeonegai15;

    @Getter @Setter
    private String syouhnnm;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private String tkbriphurikaeyoteigk;

    @Getter @Setter
    private String hhknnmkj;

    @Getter @Setter
    private String hurikaekzhosokumongon;

    @Getter @Setter
    private String hurikaekz1;

    @Getter @Setter
    private String hurikaekz2;

    @Getter @Setter
    private String hurikaekz3;

    @Getter @Setter
    private String hurikaekz4;

    @Getter @Setter
    private String hurikaekz5;

    @Getter @Setter
    private String kzhuristartanfreearea1;

    @Getter @Setter
    private String kzhuristartanfreearea2;

    @Getter @Setter
    private String kzhuristartanfreearea3;

    @Getter @Setter
    private String kzhuristartanfreearea4;

    @Getter @Setter
    private String kzhuristartanfreearea5;

    @Getter @Setter
    private String kzhuristartanfreearea6;

    @Getter @Setter
    private String kzhuristartanfreearea7;

    @Getter @Setter
    private String kzhuristartanfreearea8;

    @Getter @Setter
    private String kzhuristartanfreearea9;

    @Getter @Setter
    private String kzhuristartanfreearea10;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
