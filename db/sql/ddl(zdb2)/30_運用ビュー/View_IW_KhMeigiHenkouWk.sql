CREATE VIEW IW_KhMeigiHenkouWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     syono ,         /* 証券番号 */
     skssakuseiymd ,         /* 請求書作成日 */
     meigihnkjiyuu ,         /* 名義変更事由 */
     kyknmkn ,         /* 契約者名（カナ） */
     kyknmkj ,         /* 契約者名（漢字） */
     kyknmkjkhukakbn ,         /* 契約者名漢字化不可区分 */
     kykseiymd ,         /* 契約者生年月日 */
     kyksei ,         /* 契約者性別 */
     kkkyktdk ,         /* 契約管理契約者続柄 */
     hhknnmkn ,         /* 被保険者名（カナ） */
     hhknnmkj ,         /* 被保険者名（漢字） */
     hhknnmkjkhukakbn ,         /* 被保険者名漢字化不可区分 */
     nenkinuktkbn ,         /* 年金受取人区分 */
     sbuktnin ,         /* 死亡受取人人数 */
     sbuktkaijyokbn1 ,         /* 死亡受取人解除区分１ */
     sbuktkbn1 ,         /* 死亡受取人区分１ */
     sbuktnmkn1 ,         /* 死亡受取人名（カナ）１ */
     sbuktnmkj1 ,         /* 死亡受取人名（漢字）１ */
     sbuktnmkjhukakbn1 ,         /* 死亡受取人名漢字化不可区分１ */
     sbuktseiymd1 ,         /* 死亡受取人生年月日１ */
     sbuktbnwari1 ,         /* 死亡受取人分割割合１ */
     sbuktkaijyokbn2 ,         /* 死亡受取人解除区分２ */
     sbuktkbn2 ,         /* 死亡受取人区分２ */
     sbuktnmkn2 ,         /* 死亡受取人名（カナ）２ */
     sbuktnmkj2 ,         /* 死亡受取人名（漢字）２ */
     sbuktnmkjhukakbn2 ,         /* 死亡受取人名漢字化不可区分２ */
     sbuktseiymd2 ,         /* 死亡受取人生年月日２ */
     sbuktbnwari2 ,         /* 死亡受取人分割割合２ */
     sbuktkaijyokbn3 ,         /* 死亡受取人解除区分３ */
     sbuktkbn3 ,         /* 死亡受取人区分３ */
     sbuktnmkn3 ,         /* 死亡受取人名（カナ）３ */
     sbuktnmkj3 ,         /* 死亡受取人名（漢字）３ */
     sbuktnmkjhukakbn3 ,         /* 死亡受取人名漢字化不可区分３ */
     sbuktseiymd3 ,         /* 死亡受取人生年月日３ */
     sbuktbnwari3 ,         /* 死亡受取人分割割合３ */
     sbuktkaijyokbn4 ,         /* 死亡受取人解除区分４ */
     sbuktkbn4 ,         /* 死亡受取人区分４ */
     sbuktnmkn4 ,         /* 死亡受取人名（カナ）４ */
     sbuktnmkj4 ,         /* 死亡受取人名（漢字）４ */
     sbuktnmkjhukakbn4 ,         /* 死亡受取人名漢字化不可区分４ */
     sbuktseiymd4 ,         /* 死亡受取人生年月日４ */
     sbuktbnwari4 ,         /* 死亡受取人分割割合４ */
     stdrskkaijyokbn ,         /* 指定代理請求人解除区分 */
     stdruktkbn ,         /* 指定代理受取人区分 */
     stdrsknmkn ,         /* 指定代理請求人名（カナ） */
     stdrsknmkj ,         /* 指定代理請求人名（漢字） */
     stdrsknmkjhukakbn ,         /* 指定代理請求人名漢字化不可区分 */
     shsnmkj ,         /* 送付先氏名（漢字） */
     shskyno ,         /* 送付先郵便番号 */
     shsadr1kj ,         /* 送付先住所１（漢字）（３０桁） */
     shsadr2kj ,         /* 送付先住所２（漢字）（３０桁） */
     shsadr3kj ,         /* 送付先住所３（漢字）（３０桁） */
     honninkakninkekkakbn ,         /* 本人確認結果区分 */
     tyhysakuseiyhkbn ,         /* 帳票作成要否区分 */
     hassoukbn ,         /* 発送区分 */
     zenkaisyorikekkakbn ,         /* 前回処理結果区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     adrhenkouumu ,         /* 住所変更有無 */
     tsinyno ,         /* 通信先郵便番号 */
     tsinadr1kj ,         /* 通信先住所１（漢字） */
     tsinadr2kj ,         /* 通信先住所２（漢字） */
     tsinadr3kj ,         /* 通信先住所３（漢字） */
     tsintelno ,         /* 通信先電話番号 */
     dai2tsintelno ,         /* 第２通信先電話番号 */
     oldkyksibouymd ,         /* （旧）契約者死亡日 */
     syoruiukeymd ,         /* 書類受付日 */
     stdrskseiymd           /* 指定代理請求人生年月日 */
FROM IW_KhMeigiHenkouWk_Z;