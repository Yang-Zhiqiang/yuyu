package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJV_SmbcSibouInfoRendou;
import yuyu.def.db.mapping.GenJV_SmbcSibouInfoRendou;
import yuyu.def.db.meta.GenQJV_SmbcSibouInfoRendou;
import yuyu.def.db.meta.QJV_SmbcSibouInfoRendou;

/**
 * ＳＭＢＣ死亡情報連動ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJV_SmbcSibouInfoRendou} の JavaDoc を参照してください。
 * @see     GenJV_SmbcSibouInfoRendou
 * @see     PKJV_SmbcSibouInfoRendou
 * @see     QJV_SmbcSibouInfoRendou
 * @see     GenQJV_SmbcSibouInfoRendou
 */
@Entity
public class JV_SmbcSibouInfoRendou extends GenJV_SmbcSibouInfoRendou {

    private static final long serialVersionUID = 1L;

    public JV_SmbcSibouInfoRendou() {
    }

    public JV_SmbcSibouInfoRendou(String pSyono, String pSkno) {
        super(pSyono, pSkno);
    }

}
