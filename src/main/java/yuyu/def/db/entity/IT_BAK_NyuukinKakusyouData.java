package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.id.PKIT_BAK_NyuukinKakusyouData;
import yuyu.def.db.mapping.GenIT_BAK_NyuukinKakusyouData;
import yuyu.def.db.meta.GenQIT_BAK_NyuukinKakusyouData;
import yuyu.def.db.meta.QIT_BAK_NyuukinKakusyouData;

/**
 * 入金確証データバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_NyuukinKakusyouData} の JavaDoc を参照してください。
 * @see     GenIT_BAK_NyuukinKakusyouData
 * @see     PKIT_BAK_NyuukinKakusyouData
 * @see     QIT_BAK_NyuukinKakusyouData
 * @see     GenQIT_BAK_NyuukinKakusyouData
 */
@Entity
public class IT_BAK_NyuukinKakusyouData extends GenIT_BAK_NyuukinKakusyouData {

    private static final long serialVersionUID = 1L;

    public IT_BAK_NyuukinKakusyouData() {
    }

    public IT_BAK_NyuukinKakusyouData(
        String pKbnkey,
        String pNyuukinkakusyouno,
        String pSyono,
        String pTrkssikibetukey
        ) {
        super(
            pKbnkey,
            pNyuukinkakusyouno,
            pSyono,
            pTrkssikibetukey
            );
    }

    public IT_BAK_NyuukinKakusyouData(String pNyuukinkakusyouno,String pSyono,String pTrkssikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pNyuukinkakusyouno,pSyono,pTrkssikibetukey);
    }

}
