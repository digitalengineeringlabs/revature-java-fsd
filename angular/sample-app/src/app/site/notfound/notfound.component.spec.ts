
describe('sample',()=>{

    beforeAll(()=>{
        console.log('before all callled')
    })

    beforeEach(()=>{
        console.log('before eack callled')
    })

    //test case 1
    it('test case 1',()=>{
        var user = {}
        expect(user).toBeTruthy()
    })

    //test case 2
    it('test case 2', ()=>{
        expect(3).toBeGreaterThan(2)
    })

    describe('first set', ()=>{

        beforeEach(()=>{
            console.log('before eack sub test cases')
        })
        //test case 3
        it('test case 3',()=>{
            var user = {}
            expect(user).toBeTruthy()
        })

        //test case 4
        it('test case 4', ()=>{
            expect(3).toBeGreaterThan(2)
        })
    })

})
