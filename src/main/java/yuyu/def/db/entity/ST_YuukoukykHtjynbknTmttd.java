package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.mapping.GenST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.meta.GenQST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.meta.QST_YuukoukykHtjynbknTmttd;
import jp.co.slcs.swak.date.BizDate;

/**
 * 有効契約配当準備金（積立Ｄ）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_YuukoukykHtjynbknTmttd} の JavaDoc を参照してください。
 * @see     GenST_YuukoukykHtjynbknTmttd
 * @see     PKST_YuukoukykHtjynbknTmttd
 * @see     QST_YuukoukykHtjynbknTmttd
 * @see     GenQST_YuukoukykHtjynbknTmttd
 */
@Entity
public class ST_YuukoukykHtjynbknTmttd extends GenST_YuukoukykHtjynbknTmttd {

    private static final long serialVersionUID = 1L;

    public ST_YuukoukykHtjynbknTmttd() {
    }

    public ST_YuukoukykHtjynbknTmttd(
        BizDate pSyoriYmd,
        String pKakutyoujobcd,
        String pSyono,
        String pSrkijyunym
    ) {
        super(
            pSyoriYmd,
            pKakutyoujobcd,
            pSyono,
            pSrkijyunym
        );
    }

}
