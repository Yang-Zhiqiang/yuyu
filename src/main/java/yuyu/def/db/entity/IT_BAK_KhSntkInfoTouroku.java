package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIT_BAK_KhSntkInfoTouroku;


/**
 * 契約保全選択情報登録バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhSntkInfoTouroku} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhSntkInfoTouroku<br />
 * @see     PKIT_BAK_KhSntkInfoTouroku<br />
 * @see     QIT_BAK_KhSntkInfoTouroku<br />
 * @see     GenQIT_BAK_KhSntkInfoTouroku<br />
 */
@Entity
public class IT_BAK_KhSntkInfoTouroku extends GenIT_BAK_KhSntkInfoTouroku {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhSntkInfoTouroku() {
    }

    public IT_BAK_KhSntkInfoTouroku(String pSyono,String pTrkssikibetukey,Integer pRenno) {
        super(pSyono,pTrkssikibetukey,pRenno);
    }



}

