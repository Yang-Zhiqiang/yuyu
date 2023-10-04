package yuyu.batch.hozen.khinterf.khtmttkinyskcsvfilesel.dba;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 インターフェイス 積立金予測処理対象契約Beanクラス<br />
 */
@AllArgsConstructor
public class KhTmttkinYskCsvFileSelBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String zrnsyono;

    @Getter
    @Setter
    private String zrnkykymd;

    @Getter
    @Setter
    private BizNumber zrnitijibrpgaika;

    @Getter
    @Setter
    private BizNumber zrntmttkngaika;

    @Getter
    @Setter
    private BizNumber zrnkaiyakuhrkngaika;

    @Getter
    @Setter
    private String syouhncd;

    @Getter
    @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter
    @Setter
    private BizNumber kyksjkkktyouseiriritu;

    @Getter
    @Setter
    private C_TmttknhaibunjyoutaiKbn tmttknhaibunjyoutai;

    @Getter
    @Setter
    private C_UmuKbn targettkhkumu;

    @Getter
    @Setter
    private Integer targettkmokuhyouti;

    @Getter
    @Setter
    private C_UmuKbn teikishrtkykhukaumu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
