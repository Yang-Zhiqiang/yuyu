package yuyu.batch.direct.dstoukei.dstoukeisakusei.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_BaitaiKbn;
import yuyu.def.classification.C_DsKanyuuKeiroKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtTydnJyKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_DsMailTourokuJyoutaiKbn;
import yuyu.def.classification.C_DsSyomenTtdkHyouji;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SeisaHuyouHyj;
import yuyu.def.classification.C_YokinKbn;

/**
 * ＤＳ統計Ｆ作成Beanクラス<br />
 */
@AllArgsConstructor
public class DsToukeiInfosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String dskokno;

    @Getter @Setter
    private C_DsKokyakuJtKbn dskokyakujtkbn;

    @Getter @Setter
    private BizDate dskokyakusakuseiymd;

    @Getter @Setter
    private C_DsTeisiRiyuuKbn dsteisiriyuukbn;

    @Getter @Setter
    private BizDate dskokyakumukouymd;

    @Getter @Setter
    private C_SeisaHuyouHyj seisahuyouhyj;

    @Getter @Setter
    private BizDate dskokyakuseiymd;

    @Getter @Setter
    private String dskokyakuyno;

    @Getter @Setter
    private C_DsKanyuuKeiroKbn dskanyuukeirokbn;

    @Getter @Setter
    private C_DsKrHnnKakCdSetKbn dskrhnnkakcdsetkbn;

    @Getter @Setter
    private BizDate dskrhnnkakcdsetymd;

    @Getter @Setter
    private BizDate dskrhnnkakcdyuukouymd;

    @Getter @Setter
    private BizDate dshnnkakcdsetymd;

    @Getter @Setter
    private BizDate dskrhnnkakcdttshjyhsymd;

    @Getter @Setter
    private C_DsKrHnnKakCdTtYhKbn dskrhnnkakcdttyhkbn;

    @Getter @Setter
    private C_DsKrHnnKakCdTtTydnJyKbn dskrhnnkakcdtttydnjykbn;

    @Getter @Setter
    private BizDate syokailoginymd;

    @Getter @Setter
    private String syokailogintime;

    @Getter @Setter
    private C_BaitaiKbn syokailoginbaitaikbn;

    @Getter @Setter
    private BizDate saisinloginymd;

    @Getter @Setter
    private String saisinlogintime;

    @Getter @Setter
    private C_BaitaiKbn saisinloginbaitaikbn;

    @Getter @Setter
    private Integer dshnnkakcderrorkaisuu;

    @Getter @Setter
    private Integer dskokyakunmerrorkaisuu;

    @Getter @Setter
    private Integer dskokyakuseiymderrorkaisuu;

    @Getter @Setter
    private Integer dskokyakutelnoerrorkaisuu;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate dskykkanyuuymd;

    @Getter @Setter
    private BizDate dskykhenkouymd;

    @Getter @Setter
    private C_MukouHyj dskykmukouhyj;

    @Getter @Setter
    private BizDate dskykmukouymd;

    @Getter @Setter
    private C_DsSyomenTtdkHyouji pplessrenjidssymenttdkhyj;

    @Getter @Setter
    private C_DsMailTourokuJyoutaiKbn dsmailtourokujyoutaikbn;

    @Getter @Setter
    private String dsmailaddress;

    @Getter @Setter
    private C_DsMailSousinJyoutaiKbn dsmailsousinjyoutaikbn;

    @Getter @Setter
    private C_DsMailSousinTeisiRiyuuKbn dsmailsousintisrykbn;

    @Getter @Setter
    private String dstourokuymdtime;

    @Getter @Setter
    private String dskousinymdtime;

    @Getter @Setter
    private String skjmosno;

    @Getter @Setter
    private C_MosUketukeKbn mosuketukekbn;

    @Getter @Setter
    private C_Kyksei kyksei;

    @Getter @Setter
    private String bsyujoyadrtencd;

    @Getter @Setter
    private String bsyujdrtencd;

    @Getter @Setter
    private String gyoumuKousinTime;

    @Getter @Setter
    private C_DsTrhkserviceRiyoujkKbn dstrhkserviceriyoujkkbn;

    @Getter @Setter
    private C_DsTrhkserviceTeisiRiyuuKbn dstrhkserviceteisiriyuukbn;

    @Getter @Setter
    private BizDate dstrhkservicetourokuymd;

    @Getter @Setter
    private BizDate dstrhkservicemukouymd;

    @Getter @Setter
    private C_DsTrhkserviceKanyukeiroKbn dstrhkservicekanyukeirokbn;

    @Getter @Setter
    private C_KouzasyuruiKbn kzsyuruikbn;

    @Getter @Setter
    private String bankcd;

    @Getter @Setter
    private String sitencd;

    @Getter @Setter
    private C_YokinKbn yokinkbn;

    @Getter @Setter
    private String kouzano;

    @Getter @Setter
    private C_Kzdou kzdoukbn;

    @Getter @Setter
    private String tokuteitrhkansyono;

    @Getter @Setter
    private Integer tktrhkansyonoerrorkaisuu;

    @Getter @Setter
    private BizDate setymd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
