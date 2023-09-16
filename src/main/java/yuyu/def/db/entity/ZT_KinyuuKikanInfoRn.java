package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_KinyuuKikanInfoRn;
import yuyu.def.db.mapping.GenZT_KinyuuKikanInfoRn;
import yuyu.def.db.meta.GenQZT_KinyuuKikanInfoRn;
import yuyu.def.db.meta.QZT_KinyuuKikanInfoRn;

/**
 * 金融機関情報連動ファイルテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KinyuuKikanInfoRn} の JavaDoc を参照してください。
 * @see     GenZT_KinyuuKikanInfoRn
 * @see     PKZT_KinyuuKikanInfoRn
 * @see     QZT_KinyuuKikanInfoRn
 * @see     GenQZT_KinyuuKikanInfoRn
 */
@Entity
public class ZT_KinyuuKikanInfoRn extends GenZT_KinyuuKikanInfoRn {

    private static final long serialVersionUID = 1L;

    public ZT_KinyuuKikanInfoRn() {
    }

    public ZT_KinyuuKikanInfoRn(String pZrnkinyuukikancd, String pZrnsitencd) {
        super(pZrnkinyuukikancd, pZrnsitencd);
    }

}
