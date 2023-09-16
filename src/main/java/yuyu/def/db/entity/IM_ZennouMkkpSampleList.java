package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIM_ZennouMkkpSampleList;
import yuyu.def.db.mapping.GenIM_ZennouMkkpSampleList;
import yuyu.def.db.meta.GenQIM_ZennouMkkpSampleList;
import yuyu.def.db.meta.QIM_ZennouMkkpSampleList;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_Segcd;

/**
 * 前納未経過Ｐ検証サンプルリストパターンマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_ZennouMkkpSampleList} の JavaDoc を参照してください。
 * @see     GenIM_ZennouMkkpSampleList
 * @see     PKIM_ZennouMkkpSampleList
 * @see     QIM_ZennouMkkpSampleList
 * @see     GenQIM_ZennouMkkpSampleList
 */
@Entity
public class IM_ZennouMkkpSampleList extends GenIM_ZennouMkkpSampleList {

    private static final long serialVersionUID = 1L;

    public IM_ZennouMkkpSampleList() {
    }

    public IM_ZennouMkkpSampleList(
        C_ZennouToukeiListKbn pZennoutoukeilistkbn,
        C_ZennouKbn pZennoukbn,
        C_Segcd pKbnkeirisegcd
    ) {
        super(
            pZennoutoukeilistkbn,
            pZennoukbn,
            pKbnkeirisegcd
        );
    }

}
