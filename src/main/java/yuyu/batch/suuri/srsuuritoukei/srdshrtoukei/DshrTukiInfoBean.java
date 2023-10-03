package yuyu.batch.suuri.srsuuritoukei.srdshrtoukei;

import java.io.Serializable;

import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import lombok.Getter;
import lombok.Setter;

/**
 * 数理 数理統計 Ｄ支払統計情報テーブルBeanクラス<br/>
 */
public class DshrTukiInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String dshrtoukeisikibetukey;

    @Getter @Setter
    private Integer renno;

    @Getter @Setter
    private String skno;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private Integer seikyuurirekino;

    @Getter @Setter
    private String henkousikibetukey;

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private C_SyoriKbn syorikbn;

    @Getter @Setter
    private C_Hrkkeiro hrkkeiro;

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private Integer syouhnsdno;

    @Getter @Setter
    private C_Kykjyoutai kykjyoutai;

    @Getter @Setter
    private C_Syoumetujiyuu syoumetujiyuu;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private BizDate yendthnkymd;

    @Getter @Setter
    private BizCurrency kihons;

    @Getter @Setter
    private BizNumber yoteiriritu;

    @Getter @Setter
    private BizDate denymd;

    @Getter @Setter
    private BizCurrency siharaid;

    @Getter @Setter
    private BizDate calckijyunymd;

    @Getter @Setter
    private BizDate syoriymd2;

    @Getter @Setter
    private BizDateYM jkipjytym;

    @Getter @Setter
    private BizDate kinoubetukijyunymd;

    @Getter @Setter
    private BizNumber gengkwari;

    @Getter @Setter
    private BizCurrency itibushrgk;

    @Getter @Setter
    private BizCurrency haitoushrkin;

    @Getter @Setter
    private BizCurrency kariwariatedruigk;

    @Getter @Setter
    private BizCurrency kariwariatedgngkkngk;

    @Getter @Setter
    private BizCurrency kariwariatedshrgk;

    @Getter @Setter
    private BizCurrency dkeisanhaitoukin;

    @Getter @Setter
    private C_NaiteiKakuteiKbn dkeisannaiteikakuteikbn;

    @Getter @Setter
    private BizDateY haitounendo;

    @Getter @Setter
    private BizCurrency haitoushrkingk;

    @Getter @Setter
    private BizCurrency kariwariatedganrikindshr;

    @Getter @Setter
    private BizCurrency tumitated;

    @Getter @Setter
    private BizCurrency tumitatedmodosimae;

    @Getter @Setter
    private BizCurrency tumitatedmodosigo;

    @Getter @Setter
    private BizCurrency tkbthaitou;

    @Getter @Setter
    private BizDateY haitounendo2;

    @Getter @Setter
    private C_HaitoukinsksKbn haitoukinskskbn;

    @Getter @Setter
    private C_HaitoumeisaiKbn haitoumeisaikbn;

    @Getter @Setter
    private BizDateY fstkariwariatednendo;

    @Getter @Setter
    private BizCurrency tounendod;

    @Getter @Setter
    private C_NaiteiKakuteiKbn naiteikakuteikbn;

    @Getter @Setter
    private BizDate kariwariatedshrymd;

    @Getter @Setter
    private BizCurrency kariwariatedruigk2;

    @Getter @Setter
    private BizCurrency kariwariatedgngkkngk2;

    @Getter @Setter
    private BizCurrency kariwariatedshrgk2;

    @Getter @Setter
    private BizDate tumitatedtumitateymd;

    @Getter @Setter
    private C_TumitateDSakuseiKbn tumitatedskskbn;

    @Getter @Setter
    private BizCurrency tumitated2;

    @Getter @Setter
    private BizDate tumitatedshrkrkymd;

    @Getter @Setter
    private C_NaiteiKakuteiKbn naiteikakuteikbn2;

    @Getter @Setter
    private BizCurrency haitouganrikincalckari;

    @Getter @Setter
    private BizNumber kariwariatedriritu1;

    @Getter @Setter
    private BizNumber kariwariatedriritu2;

    @Getter @Setter
    private BizCurrency haitouganrikincalctumi;

    @Getter @Setter
    private BizNumber tumitatedriritu1;

    @Getter @Setter
    private BizNumber tumitatedriritu2;

    @Getter @Setter
    private String gyoumuKousinsyaId;

    @Getter @Setter
    private String gyoumuKousinKinou;

    @Getter @Setter
    private String gyoumuKousinTime;

    @Getter @Setter
    private String kousinsyaId;

    @Getter @Setter
    private String kousinTime;

    @Getter @Setter
    private String kousinKinou;

    @Getter @Setter
    private Long version;
}