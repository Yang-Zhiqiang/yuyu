package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKST_SuuriyouErrJyouhou;
import yuyu.def.db.mapping.GenST_SuuriyouErrJyouhou;
import yuyu.def.db.meta.GenQST_SuuriyouErrJyouhou;
import yuyu.def.db.meta.QST_SuuriyouErrJyouhou;
import jp.co.slcs.swak.date.BizDate;

/**
 * 数理用エラー情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_SuuriyouErrJyouhou} の JavaDoc を参照してください。
 * @see     GenST_SuuriyouErrJyouhou
 * @see     PKST_SuuriyouErrJyouhou
 * @see     QST_SuuriyouErrJyouhou
 * @see     GenQST_SuuriyouErrJyouhou
 */
@Entity
public class ST_SuuriyouErrJyouhou extends GenST_SuuriyouErrJyouhou {

    private static final long serialVersionUID = 1L;

    public ST_SuuriyouErrJyouhou() {
    }

    public ST_SuuriyouErrJyouhou(
        BizDate pSyoriYmd,
        String pKakutyoujobcd,
        String pSyono,
        String pGyoumuKousinTime,
        String pSuuritoukeiyouerrnaiyou
    ) {
        super(
            pSyoriYmd,
            pKakutyoujobcd,
            pSyono,
            pGyoumuKousinTime,
            pSuuritoukeiyouerrnaiyou
        );
    }

}
