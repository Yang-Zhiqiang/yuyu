package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.mapping.GenBT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.meta.GenQBT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.meta.QBT_KijituTuriHnbnKnsouTutJk;

/**
 * 期日到来本番検証用通知状況テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_KijituTuriHnbnKnsouTutJk} の JavaDoc を参照してください。
 * @see     GenBT_KijituTuriHnbnKnsouTutJk
 * @see     PKBT_KijituTuriHnbnKnsouTutJk
 * @see     QBT_KijituTuriHnbnKnsouTutJk
 * @see     GenQBT_KijituTuriHnbnKnsouTutJk
 */
@Entity
public class BT_KijituTuriHnbnKnsouTutJk extends GenBT_KijituTuriHnbnKnsouTutJk {

    private static final long serialVersionUID = 1L;

    public BT_KijituTuriHnbnKnsouTutJk() {
    }

    public BT_KijituTuriHnbnKnsouTutJk(String pSubSystemId, Integer pTysytno) {
        super(pSubSystemId, pTysytno);
    }

}
