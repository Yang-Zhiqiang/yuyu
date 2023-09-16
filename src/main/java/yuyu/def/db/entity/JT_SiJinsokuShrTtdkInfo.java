package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.mapping.GenJT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.meta.GenQJT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.meta.QJT_SiJinsokuShrTtdkInfo;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDate;

/**
 * 保険金給付金迅速支払手続情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiJinsokuShrTtdkInfo} の JavaDoc を参照してください。
 * @see     GenJT_SiJinsokuShrTtdkInfo
 * @see     PKJT_SiJinsokuShrTtdkInfo
 * @see     QJT_SiJinsokuShrTtdkInfo
 * @see     GenQJT_SiJinsokuShrTtdkInfo
 */
@Entity
public class JT_SiJinsokuShrTtdkInfo extends GenJT_SiJinsokuShrTtdkInfo {

    private static final long serialVersionUID = 1L;

    public JT_SiJinsokuShrTtdkInfo() {
    }

    public JT_SiJinsokuShrTtdkInfo(
        String pSyorisosikicd,
        String pSyoricd,
        String pHknknshrsntkno,
        BizDate pSyoruiukeymd,
        BizDate pSyoriYmd,
        BizDate pDenymd,
        String pSyono
    ) {
        super(
            pSyorisosikicd,
            pSyoricd,
            pHknknshrsntkno,
            pSyoruiukeymd,
            pSyoriYmd,
            pDenymd,
            pSyono
        );
    }

}
