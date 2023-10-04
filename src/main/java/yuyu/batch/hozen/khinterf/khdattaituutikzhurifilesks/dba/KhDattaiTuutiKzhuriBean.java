package yuyu.batch.hozen.khinterf.khdattaituutikzhurifilesks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 契約保全 インターフェイス 脱退通知（口座振替）Beanクラス
 */
@AllArgsConstructor
public class KhDattaiTuutiKzhuriBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate tyouhyouYmd;

    @Getter @Setter
    private C_SyoruiCdKbn syoruiCd;

    @Getter @Setter
    private C_HassouKbn hassouKbn;

    @Getter @Setter
    private String shsKyNo;

    @Getter @Setter
    private String shsAdr1Kj;

    @Getter @Setter
    private String shsAdr2Kj;

    @Getter @Setter
    private String shsAdr3Kj;

    @Getter @Setter
    private String shsNmKj;

    @Getter @Setter
    private String toiawaseSosikiNmKj;

    @Getter @Setter
    private String toiawaseYno;

    @Getter @Setter
    private String toiawaseAdr1Kj;

    @Getter @Setter
    private String toiawaseAdr2Kj;

    @Getter @Setter
    private String toiawaseAdr3Kj;

    @Getter @Setter
    private String toiawaseTelNo;

    @Getter @Setter
    private String toiawaseTelUktkKanou1;

    @Getter @Setter
    private String toiawaseTelUktkKanou2;

    @Getter @Setter
    private String toiawaseSosikiNmKj2;

    @Getter @Setter
    private String toiawaseTelNo2;

    @Getter @Setter
    private String hhknNmKj;

    @Getter @Setter
    private String kzInfo30Keta1 ;

    @Getter @Setter
    private String kzInfo30Keta2;

    @Getter @Setter
    private String kzInfo30Keta3;

    @Getter @Setter
    private String kouzaMaskingMsg;

    @Getter @Setter
    private String osiraseMongon1;

    @Getter @Setter
    private String osiraseMongon2;

    @Getter @Setter
    private String osiraseMongon3;

    @Getter @Setter
    private String osiraseMongon4;

    @Getter @Setter
    private String osiraseMongon5;

    @Getter @Setter
    private String osiraseMongon6;

    @Getter @Setter
    private String osiraseMongon7;

    @Getter @Setter
    private String osiraseMongon8;

    @Getter @Setter
    private String osiraseMongon9;


    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
