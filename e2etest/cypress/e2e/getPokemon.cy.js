describe('Status Pokemon Page', () => {
  it('Should get a valid pokemon', () => {
    
    let name = "Pikachu";
    let imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png";
    let moveQuantity = 96;
    
    let pokemon = "pikachu";
    cy.visit('/pokemon/'+pokemon);
    cy.get('[data-cy="name"]').should('have.text', name);
    cy.get('[data-cy="image"]').should('have.attr', 'src', imageUrl);
    cy.get('[data-cy="moves"]').should('have.length', moveQuantity);
  });

  it('Should show a error message', () => {
    
    let errorMessage = "Pokemon 124UnKnow not found";
    
    let pokemon = "124UnKnow";
    cy.visit('/pokemon/'+pokemon);
    cy.get('[data-cy="error"]').should('have.text', errorMessage);
  });

})