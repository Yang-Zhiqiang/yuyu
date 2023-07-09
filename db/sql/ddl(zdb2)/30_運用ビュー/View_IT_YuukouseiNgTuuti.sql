CREATE VIEW IT_YuukouseiNgTuuti AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     tyouhyouymd ,         /* 帳票作成日 */
     shskyno ,         /* 送付先郵便番号 */
     shsadr1kj ,         /* 送付先住所１（漢字）（３０桁） */
     shsadr2kj ,         /* 送付先住所２（漢字）（３０桁） */
     shsadr3kj ,         /* 送付先住所３（漢字）（３０桁） */
     shsnmkj ,         /* 送付先氏名（漢字） */
     toiawasesosikinmkj ,         /* 問合せ先組織名（漢字） */
     toiawaseyno ,         /* 問合せ先郵便番号 */
     toiawaseadr1kj ,         /* 問合せ先住所１（漢字） */
     toiawaseadr2kj ,         /* 問合せ先住所２（漢字） */
     toiawaseadr3kj ,         /* 問合せ先住所３（漢字） */
     toiawasetelno ,         /* 問合せ先電話番号 */
     toiawaseteluktkkanou1 ,         /* 問合せ先電話受付可能時間１ */
     toiawaseteluktkkanou2 ,         /* 問合せ先電話受付可能時間２ */
     toiawasesosikinmkj2 ,         /* 第２問合せ先組織名（漢字） */
     toiawasetelno2 ,         /* 第２問合せ先電話番号 */
     osirasemongon46keta1 ,         /* お知らせ文言（４６桁）１ */
     osirasemongon46keta2 ,         /* お知らせ文言（４６桁）２ */
     osirasemongon46keta3 ,         /* お知らせ文言（４６桁）３ */
     osirasemongon46keta4 ,         /* お知らせ文言（４６桁）４ */
     osirasemongon46keta5 ,         /* お知らせ文言（４６桁）５ */
     osirasemongon46keta6 ,         /* お知らせ文言（４６桁）６ */
     osirasemongon46keta7 ,         /* お知らせ文言（４６桁）７ */
     osirasemongon46keta8 ,         /* お知らせ文言（４６桁）８ */
     osirasemongon46keta9 ,         /* お知らせ文言（４６桁）９ */
     osirasemongon46keta10 ,         /* お知らせ文言（４６桁）１０ */
     kyknmkj ,         /* 契約者名（漢字） */
     hokenryou ,         /* 保険料 */
     hokenryou$ ,         /* 保険料(通貨型) */
     creditcardinfo1 ,         /* クレジットカード情報１ */
     creditcardinfo2 ,         /* クレジットカード情報２ */
     creditcardinfo3 ,         /* クレジットカード情報３ */
     creditcardmaskingmsg ,         /* クレジットカードマスキングＭＳＧ */
     goiraijikoutoumongon1 ,         /* ご依頼事項等文言１ */
     goiraijikoutoumongon2 ,         /* ご依頼事項等文言２ */
     goiraijikoutoumongon3 ,         /* ご依頼事項等文言３ */
     phrkmongon1 ,         /* 保険料のお払込み文言１ */
     phrkmongon2 ,         /* 保険料のお払込み文言２ */
     phrkmongon3 ,         /* 保険料のお払込み文言３ */
     phrkmongon4 ,         /* 保険料のお払込み文言４ */
     phrkmongon5 ,         /* 保険料のお払込み文言５ */
     phrkmongon6 ,         /* 保険料のお払込み文言６ */
     phrkmongon7 ,         /* 保険料のお払込み文言７ */
     phrkmongon8 ,         /* 保険料のお払込み文言８ */
     phrkmongon9 ,         /* 保険料のお払込み文言９ */
     syoruiCd ,         /* 書類コード */
     hassoukbn ,         /* 発送区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_YuukouseiNgTuuti_Z;