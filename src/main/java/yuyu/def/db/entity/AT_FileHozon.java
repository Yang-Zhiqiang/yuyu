package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAT_FileHozon;
import yuyu.def.db.mapping.GenAT_FileHozon;
import yuyu.def.db.meta.GenQAT_FileHozon;
import yuyu.def.db.meta.QAT_FileHozon;

/**
 * ファイル保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_FileHozon} の JavaDoc を参照してください。
 * @see     GenAT_FileHozon
 * @see     PKAT_FileHozon
 * @see     QAT_FileHozon
 * @see     GenQAT_FileHozon
 */
@Entity
public class AT_FileHozon extends GenAT_FileHozon {

    private static final long serialVersionUID = 1L;

    public AT_FileHozon() {
    }

    public AT_FileHozon(String pUniqueId) {
        super(pUniqueId);
    }

}
