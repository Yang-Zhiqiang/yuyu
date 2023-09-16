package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKST_YuukoukykHtjynbknKarid;
import yuyu.def.db.mapping.GenST_YuukoukykHtjynbknKarid;
import yuyu.def.db.meta.GenQST_YuukoukykHtjynbknKarid;
import yuyu.def.db.meta.QST_YuukoukykHtjynbknKarid;
import jp.co.slcs.swak.date.BizDate;

/**
 * 有効契約配当準備金（仮割当Ｄ）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_YuukoukykHtjynbknKarid} の JavaDoc を参照してください。
 * @see     GenST_YuukoukykHtjynbknKarid
 * @see     PKST_YuukoukykHtjynbknKarid
 * @see     QST_YuukoukykHtjynbknKarid
 * @see     GenQST_YuukoukykHtjynbknKarid
 */
@Entity
public class ST_YuukoukykHtjynbknKarid extends GenST_YuukoukykHtjynbknKarid {

    private static final long serialVersionUID = 1L;

    public ST_YuukoukykHtjynbknKarid() {
    }

    public ST_YuukoukykHtjynbknKarid(
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
