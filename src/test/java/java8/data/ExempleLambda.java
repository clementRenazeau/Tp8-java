package java8.data;

public class ExempleLambda {

		static interface Operation {
			int calculer(int nb1, int nb2);
		}

		static class Addition implements Operation {

			@Override
			public int calculer(int nb1, int nb2) {
				return nb1 + nb2;
			}

		}

		static void afficher(int n1, int n2, Operation op) {
			System.out.println(String.format("Calcul(%d,%d) = %d", n1, n2, op.calculer(n1, n2)));
		}

		public static void main(String[] args) {

			afficher(2, 3, new Addition());

			Operation soustraction = new Operation() {

				// je peux créer un champ
				String name;

				@Override
				public int calculer(int nb1, int nb2) {
					return nb1 - nb2;
				}

			};

			afficher(2, 3, soustraction);

			afficher(2, 3, new Operation() {

				@Override
				public int calculer(int nb1, int nb2) {
					return nb1 * nb2;
				}
			});
			
			/* Exemple Swing
			JButton bt = new JButton("Valider");
			bt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Il a cliqué !!!");
					
				}
			});
			 */
			// Lambda - niveau 1
			afficher(2, 3, (int nb1, int nb2) -> {
					return nb1 * nb2;
			});
			
			// Lambda - niveau 2
			afficher(2, 3, (nb1, nb2) -> {
					return nb1 * nb2;
			});
			
			// Lambda - niveau 3
			afficher(2, 3, (nb1, nb2) -> nb1 * nb2);
			
			Operation carreDuPremier = (nb1, nb2) -> nb1 * nb1;
			afficher(2, 3, carreDuPremier);


		}

	}
