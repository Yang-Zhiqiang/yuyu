package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_TRGinkouTouhaigou;
import yuyu.def.db.mapping.GenIT_TRGinkouTouhaigou;
import yuyu.def.db.meta.GenQIT_TRGinkouTouhaigou;
import yuyu.def.db.meta.QIT_TRGinkouTouhaigou;

/**
 * 銀行統廃合ＴＲテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_TRGinkouTouhaigou} の JavaDoc を参照してください。
 * @see     GenIT_TRGinkouTouhaigou
 * @see     PKIT_TRGinkouTouhaigou
 * @see     QIT_TRGinkouTouhaigou
 * @see     GenQIT_TRGinkouTouhaigou
 */
@Entity
public class IT_TRGinkouTouhaigou extends GenIT_TRGinkouTouhaigou {

    private static final long serialVersionUID = 1L;

    public IT_TRGinkouTouhaigou() {
    }

    public IT_TRGinkouTouhaigou(String pBfrikkatuseibibankcd, String pBfrikkatuseibisitencd) {
        super(pBfrikkatuseibibankcd, pBfrikkatuseibisitencd);
    }

}
