package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;



public class DAO {

	private final DataSource myDataSource;

	/**
	 * Construit le AO avec sa source de données
	 * @param dataSource la source de données à utiliser
	 */
	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
        
        /**
         * Permet d'avoir le code d'un client en fonction de Contact  
         * @return Code du Client
         * @throws java.sql.SQLException renvoyées par JDBC
         */
        public String codeClient(String contact) throws SQLException {
            String result = null;;
            String sql = "SELECT CODE FROM CLIENT WHERE CONTACT= '?'";
            
            try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, contact);
                        try (ResultSet resultSet = stmt.executeQuery()) {
				if (resultSet.next()) {
					result = resultSet.getString("LastName");
				}
			}
			
		}
            
            return result;
        }
        
        /**
         * permet d'avoir une liste de produits dont le nom possède le mot clé entré en argument
         * @return ou liste de produits
         * @throws java.sql.SQLException renvoyées par JDBC
         */
        public List<Produit> selectProduct(String nom) throws SQLException {
            
            List<Produit> result = new LinkedList<>();
            
            String sql = "SELECT * FROM PRODUIT WHERE Nom LIKE '%?%'";
            try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            
                        }
            }
            return result;
        }
            
        /**
         * 
         * @throws SQLException renvoyées par JDBC
         */
        public List<Produit> allProducts(String cat) throws SQLException {
            
            List<Produit> result = new LinkedList<>();
            
            String sql = "SELECT * FROM PRODUIT INNER JOIN CATEGORIE ON PRODUIT.CATEGORIE = CATEGORIE.CODE WHERE LIBELLE LIKE '%?%'";;

            try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            String nProduit=rs.getString("NOM");
                            int fournisseur=rs.getInt("FOURNISSEUR");
                            int categorie=rs.getInt("CATEGORIE");
                            float prixUnitaire=rs.getFloat("PRIX_UNITAIRE");
                            float quantiteParUnite=rs.getFloat("QAUNTITE_PAR_UNITE");
                            int unitesEnStock=rs.getInt("UNITES_EN_STOCK");
                            int unites_Commandees=rs.getInt("UNITES_COMMANDEES");
                            int niveauReaprovi=rs.getInt("NIVEAU_DE_REAPPROVI");
                            boolean indisponible;
                            if rs.getInt();
                        }
            }
            return result;
        }
        
	/**
	 * Contenu de la table DISCOUNT_CODE
	 * @return Liste des clients
	 * @throws SQLException renvoyées par JDBC
	 */
	public List<DiscountCode> allCodes() throws SQLException {

		List<DiscountCode> result = new LinkedList<>();

		String sql = "SELECT * FROM DISCOUNT_CODE ORDER BY DISCOUNT_CODE";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("DISCOUNT_CODE");
				float rate = rs.getFloat("RATE");
				DiscountCode c = new DiscountCode(id, rate);
				result.add(c);
			}
		}
		return result;
	}
        

	/**
	 * Ajout d'un enregistrement dans la table DISCOUNT_CODE
	 * @param code le code (non null)
	 * @param rate le taux (positive or 0)
	 * @return 1 si succès, 0 sinon
	 * @throws SQLException renvoyées par JDBC
	 */
	public int addDiscountCode(String code, float rate) throws SQLException {
		int result = 0;
		String sql = "INSERT INTO DISCOUNT_CODE VALUES (?, ?)";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, code);
			stmt.setFloat(2, rate);
			result = stmt.executeUpdate();
		}
		return result;
	}

		
	/**
	 * Supprime un enregistrement dans la table DISCOUNT_CODE
	 * @param code la clé de l'enregistrement à supprimer
	 * @return le nombre d'enregistrements supprimés (1 ou 0)
	 * @throws java.sql.SQLException renvoyées par JDBC
	 **/
	public int deleteDiscountCode(String code) throws SQLException {
		int result = 0;
		String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, code);
			result = stmt.executeUpdate();
		}
		return result;
	}


}
