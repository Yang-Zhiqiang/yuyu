CREATE VIEW BT_IdouSkMeigi AS SELECT
     mosno ,         /* 申込番号 */
     renno3keta ,         /* 連番（３桁） */
     hhknnmkn ,         /* 被保険者名（カナ） */
     hhknnmkj ,         /* 被保険者名（漢字） */
     hhknseiymd ,         /* 被保険者生年月日 */
     hhknsei ,         /* 被保険者性別 */
     hhknyno ,         /* 被保険者郵便番号 */
     hhknadr1kj ,         /* 被保険者住所１（漢字） */
     hhknadr2kj ,         /* 被保険者住所２（漢字） */
     hhknadr3kj ,         /* 被保険者住所３（漢字） */
     hhkntelno ,         /* 被保険者電話番号 */
     hhknsykgycd ,         /* 被保険者職業コード */
     kyknmkn ,         /* 契約者名（カナ） */
     kyknmkj ,         /* 契約者名（漢字） */
     kykseiymd ,         /* 契約者生年月日 */
     nenkinuktnmkana ,         /* 年金受取人名（カナ） */
     nenkinuktnmkanji ,         /* 年金受取人名（漢字） */
     nenkinuktseiymd ,         /* 年金受取人生年月日 */
     tsinyno ,         /* 通信先郵便番号 */
     tsinadr1kj ,         /* 通信先住所１（漢字） */
     tsinadr2kj ,         /* 通信先住所２（漢字） */
     tsinadr3kj ,         /* 通信先住所３（漢字） */
     tsintelno ,         /* 通信先電話番号 */
     sbuktnmkn1 ,         /* 死亡受取人名（カナ）１ */
     sbuktnmkj1 ,         /* 死亡受取人名（漢字）１ */
     sbuktnmkn2 ,         /* 死亡受取人名（カナ）２ */
     sbuktnmkj2 ,         /* 死亡受取人名（漢字）２ */
     sbuktnmkn3 ,         /* 死亡受取人名（カナ）３ */
     sbuktnmkj3 ,         /* 死亡受取人名（漢字）３ */
     sbuktnmkn4 ,         /* 死亡受取人名（カナ）４ */
     sbuktnmkj4 ,         /* 死亡受取人名（漢字）４ */
     stdrsknmkn ,         /* 指定代理請求人名（カナ） */
     stdrsknmkj ,         /* 指定代理請求人名（漢字） */
     kykdairinmkn ,         /* 契約者代理人名（カナ） */
     kykdairinmkj ,         /* 契約者代理人名（漢字） */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     kzkykdoukbn ,         /* 口座名義契約者同一人区分 */
     kzktourokunmkn1 ,         /* 家族登録名（カナ）１ */
     kzktourokunmkj1 ,         /* 家族登録名（漢字）１ */
     kzktourokunmkn2 ,         /* 家族登録名（カナ）２ */
     kzktourokunmkj2 ,         /* 家族登録名（漢字）２ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_IdouSkMeigi_Z;