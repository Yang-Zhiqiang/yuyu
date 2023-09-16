package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.db.mapping.GenST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.db.meta.GenQST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.db.meta.QST_DshrTukiTyukeiyouItzHzn;

/**
 * Ｄ支払統計中継用一時保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_DshrTukiTyukeiyouItzHzn} の JavaDoc を参照してください。
 * @see     GenST_DshrTukiTyukeiyouItzHzn
 * @see     PKST_DshrTukiTyukeiyouItzHzn
 * @see     QST_DshrTukiTyukeiyouItzHzn
 * @see     GenQST_DshrTukiTyukeiyouItzHzn
 */
@Entity
public class ST_DshrTukiTyukeiyouItzHzn extends GenST_DshrTukiTyukeiyouItzHzn {

    private static final long serialVersionUID = 1L;

    public ST_DshrTukiTyukeiyouItzHzn() {
    }

    public ST_DshrTukiTyukeiyouItzHzn(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
