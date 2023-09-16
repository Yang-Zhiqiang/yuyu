package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.mapping.GenBT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.meta.GenQBT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.meta.QBT_KijituTuriHnbnKnsouTut;
import jp.co.slcs.swak.date.BizDate;

/**
 * 期日到来本番検証用通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_KijituTuriHnbnKnsouTut} の JavaDoc を参照してください。
 * @see     GenBT_KijituTuriHnbnKnsouTut
 * @see     PKBT_KijituTuriHnbnKnsouTut
 * @see     QBT_KijituTuriHnbnKnsouTut
 * @see     GenQBT_KijituTuriHnbnKnsouTut
 */
@Entity
public class BT_KijituTuriHnbnKnsouTut extends GenBT_KijituTuriHnbnKnsouTut {

    private static final long serialVersionUID = 1L;

    public BT_KijituTuriHnbnKnsouTut() {
    }

    public BT_KijituTuriHnbnKnsouTut(
        BizDate pSyoriYmd,
        String pSubSystemId,
        Integer pTysytno
    ) {
        super(
            pSyoriYmd,
            pSubSystemId,
            pTysytno
        );
    }

}
