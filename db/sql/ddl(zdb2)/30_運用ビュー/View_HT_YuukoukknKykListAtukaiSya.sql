CREATE VIEW HT_YuukoukknKykListAtukaiSya AS SELECT
     mosno ,         /* 申込番号 */
     tyouhyouymd ,         /* 帳票作成日 */
     keikakbn ,         /* 経過区分 */
     renno ,         /* 連番 */
     kinyuucd ,         /* 金融機関コード */
     kinyuusitencd ,         /* 金融機関支店コード */
     drtencd ,         /* 代理店コード */
     drtennm ,         /* 代理店名 */
     tratkiagcd ,         /* 取扱代理店コード */
     tratkiagnm ,         /* 取扱代理店名 */
     oyadrtencd ,         /* 親代理店コード */
     oyadrtennm ,         /* 親代理店名 */
     jimusyocd ,         /* 事務所コード */
     bosyuucd ,         /* 募集人コード */
     bosyuutrkno ,         /* 募集人登録番号 */
     bosyuunm ,         /* 募集人名 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_YuukoukknKykListAtukaiSya_Z;