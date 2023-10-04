package yuyu.batch.hozen.khansyuu.khsinkokuyokokutuutisks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;

/**
 * 申告予告通知作成Beanクラスです。<br />
 */
@AllArgsConstructor
public class SinkokuYokokuTuutiSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private BizDateYM jkipjytym;

    @Getter @Setter
    private C_Kykjyoutai kykjyoutai;

    @Getter @Setter
    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

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

    //    @Getter @Setter
    //    private BizDate kykseiymd;

    @Getter @Setter
    private String hhknnmkj;

    //    @Getter @Setter
    //    private BizDate hhknseiymd;

    @Override
    public String toString(){
        return BeanUtil.toString(this);
    }
}
