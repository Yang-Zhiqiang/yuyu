CREATE VIEW HT_BosDairiten AS SELECT
     mosno ,         /* 申込番号 */
     renno ,         /* 連番 */
     bsyujoyadrtencd ,         /* 募集時親代理店コード */
     drtensykbn ,         /* 代理店種別区分 */
     kinyuucd ,         /* 金融機関コード */
     kinyuusitencd ,         /* 金融機関支店コード */
     tratkiagcd ,         /* 取扱代理店コード */
     oyadrtencd ,         /* 親代理店コード */
     jimusyocd ,         /* 事務所コード */
     bosyuutrkno ,         /* 募集人登録番号 */
     cifcd ,         /* ＣＩＦコード */
     drtencd ,         /* 代理店コード */
     bosyuucd ,         /* 募集人コード */
     inputbosyuucd ,         /* 入力募集人コード */
     daibosyuucd ,         /* 代表募集人コード */
     tratkikouinncd ,         /* 取扱行員コード */
     yuuseikbn ,         /* 郵政区分 */
     kyokusyocd ,         /* 局所コード */
     yuuseisyainno ,         /* 郵政社員番号 */
     bunwari ,         /* 分担割合 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_BosDairiten_Z;