package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_AzukarikinKessankanri;
import yuyu.def.db.mapping.GenIT_AzukarikinKessankanri;
import yuyu.def.db.meta.GenQIT_AzukarikinKessankanri;
import yuyu.def.db.meta.QIT_AzukarikinKessankanri;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 預り金決算管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_AzukarikinKessankanri} の JavaDoc を参照してください。
 * @see     GenIT_AzukarikinKessankanri
 * @see     PKIT_AzukarikinKessankanri
 * @see     QIT_AzukarikinKessankanri
 * @see     GenQIT_AzukarikinKessankanri
 */
@Entity
public class IT_AzukarikinKessankanri extends GenIT_AzukarikinKessankanri {

    private static final long serialVersionUID = 1L;

    public IT_AzukarikinKessankanri() {
    }

    public IT_AzukarikinKessankanri(
        String pSyono,
        BizDate pKessankijyunymd,
        String pHenkousikibetukey,
        C_Tuukasyu pTuukasyu
    ) {
        super(
            pSyono,
            pKessankijyunymd,
            pHenkousikibetukey,
            pTuukasyu
        );
    }

}
