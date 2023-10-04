package yuyu.batch.hozen.khansyuu.khdattaimikaisyoulistsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;

/**
 * 脱退未解消Beanクラスです。<br />
 * @author  斉　孝民
 * @version 2017/10/30 斉　孝民 : 新規作成<br />
 *          2018/11/06 任　暁芸: 2019年03月25日対応<br />
 */
@AllArgsConstructor
public class KhDattaiMikaishoBean implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 区分キー */
    @Getter @Setter
    private String kbnkey;

    /** 証券番号 */
    @Getter @Setter
    private String syono;

    /** 処理年月日 */
    @Getter @Setter
    private BizDate syoriYmd;

    /** 処理組織コード */
    @Getter @Setter
    private String syorisosikicd;

    /** 脱退経路 */
    @Getter @Setter
    private C_Dattaikeiro dattaikeiro;

    /** 脱退理由区分 */
    @Getter @Setter
    private C_DattairiyuuKbn dattairiyuukbn;

    /** コメント（１２４桁） */
    @Getter @Setter
    private String comment124keta;

    /** 業務用更新者ＩＤ */
    @Getter @Setter
    private String gyoumuKousinsyaId;

    /**
     * 文字列取得処理
     * @return 文字列化後Bean
     */
    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
