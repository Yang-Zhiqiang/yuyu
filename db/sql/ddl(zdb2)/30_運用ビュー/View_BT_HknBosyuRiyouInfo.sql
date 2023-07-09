CREATE VIEW BT_HknBosyuRiyouInfo AS SELECT
     drtencd ,         /* 代理店コード */
     gwriyoukbn ,         /* ＧＷ利用区分 */
     gwkykrendouumukbn ,         /* ＧＷ契約データ連動有無区分 */
     gwtsryrendouumukbn ,         /* ＧＷ手数料データ連動有無区分 */
     gwmisyuurendouumukbn ,         /* ＧＷ未収データ連動有無区分 */
     issriyoukbn ,         /* ＩＳＳ利用区分 */
     gwtkyyoteiymd ,         /* ＧＷ適用予定日 */
     gwsousinsikibetusi ,         /* ＧＷ送信識別子 */
     gwtsrykbn ,         /* ＧＷ手数料区分 */
     internetstzkriyoukbn ,         /* インターネット接続利用区分 */
     hokenbossysriyoukbn ,         /* 保険募集システム利用区分 */
     lphteikeitiginkbn ,         /* ＬＰＨ提携地銀区分 */
     tmbosyuukbn ,         /* 対面募集区分 */
     hitmbosyuukbn ,         /* 非対面募集区分 */
     kansyoutuutisakuseiyhkbn ,         /* 代理店勧奨通知作成要否区分 */
     fatcakakuninyhkbn ,         /* FATCA確認要否区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_HknBosyuRiyouInfo_Z;