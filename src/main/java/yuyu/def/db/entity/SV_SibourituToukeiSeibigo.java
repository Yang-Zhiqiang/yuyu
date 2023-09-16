package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKSV_SibourituToukeiSeibigo;
import yuyu.def.db.mapping.GenSV_SibourituToukeiSeibigo;
import yuyu.def.db.meta.GenQSV_SibourituToukeiSeibigo;
import yuyu.def.db.meta.QSV_SibourituToukeiSeibigo;

/**
 * 死亡率統計整備後情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_SibourituToukeiSeibigo} の JavaDoc を参照してください。
 * @see     GenSV_SibourituToukeiSeibigo
 * @see     PKSV_SibourituToukeiSeibigo
 * @see     QSV_SibourituToukeiSeibigo
 * @see     GenQSV_SibourituToukeiSeibigo
 */
@Entity
public class SV_SibourituToukeiSeibigo extends GenSV_SibourituToukeiSeibigo {

    private static final long serialVersionUID = 1L;

    public SV_SibourituToukeiSeibigo() {
    }

    public SV_SibourituToukeiSeibigo(
        String pSyono,
        String pGyoumuKousinKinou,
        String pGyoumuKousinTime
    ) {
        super(
            pSyono,
            pGyoumuKousinKinou,
            pGyoumuKousinTime
        );
    }

}
