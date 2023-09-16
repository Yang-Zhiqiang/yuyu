package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAS_Sakujyotaisyo;
import yuyu.def.db.mapping.GenAS_Sakujyotaisyo;
import yuyu.def.db.meta.GenQAS_Sakujyotaisyo;
import yuyu.def.db.meta.QAS_Sakujyotaisyo;

/**
 * 削除対象基幹テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_Sakujyotaisyo} の JavaDoc を参照してください。
 * @see     GenAS_Sakujyotaisyo
 * @see     PKAS_Sakujyotaisyo
 * @see     QAS_Sakujyotaisyo
 * @see     GenQAS_Sakujyotaisyo
 */
@Entity
public class AS_Sakujyotaisyo extends GenAS_Sakujyotaisyo {

    private static final long serialVersionUID = 1L;

    public AS_Sakujyotaisyo() {
    }

    public AS_Sakujyotaisyo(String pSakujyoTableId) {
        super(pSakujyoTableId);
    }

}
