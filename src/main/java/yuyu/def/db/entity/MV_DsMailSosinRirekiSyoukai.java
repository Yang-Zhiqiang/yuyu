package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKMV_DsMailSosinRirekiSyoukai;
import yuyu.def.db.mapping.GenMV_DsMailSosinRirekiSyoukai;
import yuyu.def.db.meta.GenQMV_DsMailSosinRirekiSyoukai;
import yuyu.def.db.meta.QMV_DsMailSosinRirekiSyoukai;
import jp.co.slcs.swak.date.BizDate;

/**
 * ＤＳメール送信履歴照会ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMV_DsMailSosinRirekiSyoukai} の JavaDoc を参照してください。
 * @see     GenMV_DsMailSosinRirekiSyoukai
 * @see     PKMV_DsMailSosinRirekiSyoukai
 * @see     QMV_DsMailSosinRirekiSyoukai
 * @see     GenQMV_DsMailSosinRirekiSyoukai
 */
@Entity
public class MV_DsMailSosinRirekiSyoukai extends GenMV_DsMailSosinRirekiSyoukai {

    private static final long serialVersionUID = 1L;

    public MV_DsMailSosinRirekiSyoukai() {
    }

    public MV_DsMailSosinRirekiSyoukai(
        BizDate pDsdatasakuseiymd,
        String pDskokno,
        Integer pDsmailhaisinrenban
    ) {
        super(
            pDsdatasakuseiymd,
            pDskokno,
            pDsmailhaisinrenban
        );
    }

}
